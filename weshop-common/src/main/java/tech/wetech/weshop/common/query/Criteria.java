package tech.wetech.weshop.common.query;

import tech.wetech.weshop.common.utils.Fn;
import tech.wetech.weshop.common.utils.JsonUtil;
import tech.wetech.weshop.common.utils.Reflections;
import tech.wetech.weshop.common.utils.StringUtil;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 需要结合jpa注解一起使用
 *
 * @author cjbi
 */
public class Criteria<A, B> {

    private Statement statement;

    //缓存
    private static final Map<Class<?>, EntityTable> entityTableCache = new ConcurrentHashMap<>();

    static class Statement<A> {

        //类名
        private Class<A> clazz;

        //字段
        private List<String> fields;

        //条件
        private List<Criterion> criterions;

        //第几页
        private Integer pageNum;

        //数量
        private Integer pageSize;

        //排序字段
        private String sortName;

        //顺序
        private SortOrder sortOrder;

    }

    static class EntityTable {
        private String tableName;
        private Map<String, String> fieldsMap;
    }

    enum SortOrder {
        ASC, DESC
    }

    static class Criterion {
        private String property;
        private Object value;
        private Object secondValue;
        private String condition;
        private String andOr;
        private ValueType valueType;

        enum ValueType {
            noValue, singleValue, betweenValue, listValue
        }

        public Criterion(String property, String condition, String andOr) {
            this.property = property;
            this.condition = condition;
            this.andOr = andOr;
            this.valueType = ValueType.noValue;
        }


        public Criterion(String property, Object value, String condition, String andOr) {
            this.property = property;
            this.value = value;
            this.condition = condition;
            this.andOr = andOr;

            if (value instanceof Iterable) {
                this.valueType = ValueType.listValue;
            } else {
                this.valueType = ValueType.singleValue;
            }
        }

        public Criterion(String property, Object value1, Object value2, String condition, String andOr) {
            this.property = property;
            this.value = value1;
            this.secondValue = value2;
            this.condition = condition;
            this.andOr = andOr;
            this.valueType = ValueType.betweenValue;
        }

        public Object[] getValues() {
            if (value != null) {
                if (secondValue != null) {
                    return new Object[]{value, secondValue};
                } else {
                    return new Object[]{value};
                }
            } else {
                return new Object[]{};
            }
        }
    }

    /**
     * 缓存实体类和表的映射关系
     *
     * @param entityClass
     */
    private void cacheEntityTable(Class entityClass) {
        if (!entityTableCache.containsKey(entityClass)) {
            Table table = (Table) entityClass.getAnnotation(Table.class);
            Map<String, String> fieldsMap = new LinkedHashMap<>();
            Field[] declaredFields = entityClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(Column.class)) {
                    Column column = declaredField.getAnnotation(Column.class);
                    fieldsMap.put(declaredField.getName(), column.name());
                } else {
                    String s = StringUtil.convertByStyle(declaredField.getName(), Style.camelhump);
                    fieldsMap.put(declaredField.getName(), s);
                }
            }

            EntityTable entityTable = new EntityTable();
            entityTable.tableName = table.name();
            entityTable.fieldsMap = fieldsMap;

            entityTableCache.put(entityClass, entityTable);
        }
    }

    private Criteria(Class entityClass) {
        statement = new Statement();
        statement.criterions = new LinkedList();
        statement.clazz = entityClass;
        cacheEntityTable(entityClass);
    }

    public static <A, B> Criteria<A, B> of(Class<A> entityClass) {
        return new Criteria<>(entityClass);
    }

    public Criteria<A, B> page(Integer pageNum, Integer pageSize) {
        this.statement.pageNum = pageNum;
        this.statement.pageSize = pageSize;
        return this;
    }

    public Criteria<A, B> sort(Fn<A, B> fn, SortOrder sortOrder) {
        this.statement.sortName = Reflections.fnToFieldName(fn);
        this.statement.sortOrder = sortOrder;
        return this;
    }

    public Criteria<A, B> fields(Fn<A, B>... fns) {
        this.statement.fields = Arrays.asList(Reflections.fnToFieldName(fns));
        return this;
    }

    public Criteria<A, B> andIsNotNull(Fn<A, B> fn) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), "is not null", "and"));
        return this;
    }

    public Criteria<A, B> andEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "=", "and"));
        return this;
    }

    public Criteria<A, B> andNotEqualTo(Fn<A, B> fn, Object value) {
        new Criterion(Reflections.fnToFieldName(fn), value, "<>", "and");
        return this;
    }

    public Criteria<A, B> andGreaterThan(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, ">", "and"));
        return this;
    }

    public Criteria<A, B> andGreaterThanOrEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, ">=", "and"));
        return this;
    }

    public Criteria<A, B> andLessThan(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "<", "and"));
        return this;
    }

    public Criteria<A, B> andLessThanOrEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "<=", "and"));
        return this;
    }

    public Criteria<A, B> andIn(Fn<A, B> fn, Iterable values) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), values, "in", "and"));
        return this;
    }

    public Criteria<A, B> andNotIn(Fn<A, B> fn, Iterable values) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), values, "not in", "and"));
        return this;
    }

    public Criteria<A, B> andBetween(Fn<A, B> fn, Object value1, Object value2) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value1, value2, "between", "and"));
        return this;
    }

    public Criteria<A, B> andNotBetween(Fn<A, B> fn, Object value1, Object value2) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value1, value2, "not between", "and"));
        return this;
    }

    public Criteria<A, B> andLike(Fn<A, B> fn, String value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "like", "and"));
        return this;
    }

    public Criteria<A, B> andNotLike(Fn<A, B> fn, String value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "not like", "and"));
        return this;
    }

    public Criteria<A, B> orIsNull(Fn<A, B> fn) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), "is null", "or"));
        return this;
    }

    public Criteria<A, B> orIsNotNull(Fn<A, B> fn) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), "is not null", "or"));
        return this;
    }

    public Criteria<A, B> orEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "=", "or"));
        return this;
    }

    public Criteria<A, B> orNotEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "<>", "or"));
        return this;
    }

    public Criteria<A, B> orGreaterThan(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, ">", "or"));
        return this;
    }

    public Criteria<A, B> orGreaterThanOrEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, ">=", "or"));
        return this;
    }

    public Criteria<A, B> orLessThan(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "<", "or"));
        return this;
    }

    public Criteria<A, B> orLessThanOrEqualTo(Fn<A, B> fn, Object value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "<=", "or"));
        return this;
    }

    public Criteria<A, B> orIn(Fn<A, B> fn, Iterable values) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), values, "in", "or"));
        return this;
    }

    public Criteria<A, B> orNotIn(Fn<A, B> fn, Iterable values) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), values, "not in", "or"));
        return this;
    }

    public Criteria<A, B> orBetween(Fn<A, B> fn, Object value1, Object value2) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value1, value2, "between", "or"));
        return this;
    }

    public Criteria<A, B> orNotBetween(Fn<A, B> fn, Object value1, Object value2) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value1, value2, "not between", "or"));
        return this;
    }

    public Criteria<A, B> orLike(Fn<A, B> fn, String value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "like", "or"));
        return this;
    }

    public Criteria<A, B> orNotLike(Fn<A, B> fn, String value) {
        this.statement.criterions.add(new Criterion(Reflections.fnToFieldName(fn), value, "not like", "or"));
        return this;
    }

    public String getSql() {
        StringBuilder sql = new StringBuilder("");
        sql.append(SqlHelper.selectColumns(statement));
        sql.append(SqlHelper.fromTable(statement));
        sql.append(SqlHelper.whereClause(statement));
        sql.append(SqlHelper.orderByClause(statement));
        sql.append(SqlHelper.limit(statement));
        return sql.toString();
    }

    public static class SqlHelper {

        public static String selectColumns(Statement statement) {
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            if (statement.fields != null && statement.fields.size() > 0) {
                List<String> columns = new ArrayList();
                for (Object fieldStr : statement.fields) {
                    columns.add(entityTable.fieldsMap.get(fieldStr));
                }
                return " select " + columns.stream().collect(Collectors.joining(","));
            } else {
                Map<String, String> fieldsMap = entityTable.fieldsMap;
                return " select " + fieldsMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.joining(","));
            }
        }

        public static String fromTable(Statement statement) {
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            return " from " + entityTable.tableName;
        }

        /**
         * 条件语句
         *
         * @param statement
         * @return
         */
        public static String whereClause(Statement statement) {
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            List<Criterion> criterions = statement.criterions;
            StringBuilder whereClause = new StringBuilder();
            if (criterions.size() > 0) {

                for (int i = 0; i < criterions.size(); i++) {
                    Criterion criterion = criterions.get(i);
                    if (i == 0) {
                        whereClause.append(" where ");
                    } else {
                        whereClause.append(" " + criterion.andOr + " ");
                    }
                    if (criterion.valueType == Criterion.ValueType.noValue) {
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition);
                    }
                    if (criterion.valueType == Criterion.ValueType.singleValue) {
                        if (!(criterion.value instanceof Number)) {
                            criterion.value = "'" + criterion.value + "'";
                        }
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition + " " + criterion.value);
                    }
                    if (criterion.valueType == Criterion.ValueType.betweenValue) {
                        if (!(criterion.value instanceof Number)) {
                            criterion.value = "'" + criterion.value + "'";
                        }
                        if (!(criterion.secondValue instanceof Number)) {
                            criterion.secondValue = "'" + criterion.secondValue + "'";
                        }
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition + " " + criterion.value + " AND " + criterion.secondValue);
                    }
                    if (criterion.valueType == Criterion.ValueType.listValue) {
                        Iterable iterable = (Iterable) criterion.value;
                        StringBuilder listItem = new StringBuilder();
                        for (Object o : iterable) {
                            if (!(o instanceof Number)) {
                                o = "'" + o + "'";
                            }
                            listItem.append(o).append(",");
                        }
                        if (listItem.length() > 0) {
                            listItem.deleteCharAt(listItem.length() - 1);
                        }
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition + " (" + listItem + ")");
                    }
                }
            }
            return whereClause.toString();
        }

        public static String orderByClause(Statement statement) {
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            String sortName = statement.sortName;
            if (sortName == null) {
                return "";
            }
            return " order by " + entityTable.fieldsMap.get(sortName) + " " + statement.sortOrder;
        }

        public static String limit(Statement statement) {
            Integer offset = statement.pageSize;
            if (statement.pageNum > 0) {
                Integer limit = (statement.pageNum - 1) * statement.pageSize;
                return " limit " + limit + "," + offset;
            }
            return " limit " + offset;
        }

    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Criteria<GoodsTest, Object> criteria = Criteria.of(GoodsTest.class)
                    .fields(GoodsTest::getId, GoodsTest::getAttributeCategory, GoodsTest::getCreateTime, GoodsTest::getListPicUrl)
                    .page(3, 10)
                    .sort(GoodsTest::getId, SortOrder.ASC)
                    .andIsNotNull(GoodsTest::getAppExclusivePrice)
                    .andEqualTo(GoodsTest::getCounterPrice, "222")
                    .andEqualTo(GoodsTest::getBrandId, 333)
                    .orBetween(GoodsTest::getGoodsNumber, 1, 1000)
                    .orIn(GoodsTest::getId, Arrays.asList(111, 222, 333))
                    .orNotIn(GoodsTest::getListPicUrl, Arrays.asList("aaa", "bbb", "ccc","ddd"))
                    .sort(GoodsTest::getBrandId, SortOrder.DESC);
            System.out.println(JsonUtil.getInstance().obj2json(criteria));
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - time) + "ms");
    }
}
