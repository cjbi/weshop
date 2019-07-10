package tech.wetech.weshop.common.utils;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 需要结合jpa注解一起使用
 *
 * @author cjbi@outlook.com
 */
public class Criteria<A, B> implements Serializable {

    private Statement statement;

    //缓存
    private static final Map<Class<?>, EntityTable> entityTableCache = new ConcurrentHashMap<>();

    public static class Statement<A> {

        //类名
        private Class<A> clazz;

        //字段
        private String[] fields;

        //条件
        private List<Criterion> criterions;

        //第几页
        private int pageNum;

        //数量
        private int pageSize;

        //排序字段
        private String[] sortNames;

        private String sortOrder;

        public Class<A> getClazz() {
            return clazz;
        }

        public void setClazz(Class<A> clazz) {
            this.clazz = clazz;
        }

        public String[] getFields() {
            return fields;
        }

        public void setFields(String[] fields) {
            this.fields = fields;
        }

        public List<Criterion> getCriterions() {
            return criterions;
        }

        public void setCriterions(List<Criterion> criterions) {
            this.criterions = criterions;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String[] getSortNames() {
            return sortNames;
        }

        public void setSortNames(String[] sortNames) {
            this.sortNames = sortNames;
        }

        public String getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
        }
    }

    public static class EntityTable {
        private String tableName;
        private Map<String, String> fieldsMap;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public Map<String, String> getFieldsMap() {
            return fieldsMap;
        }

        public void setFieldsMap(Map<String, String> fieldsMap) {
            this.fieldsMap = fieldsMap;
        }
    }

    public static class Criterion {
        private String property;
        private Object value;
        private Object secondValue;
        private String condition;
        private String andOr;
        private ValueType valueType;

        public enum ValueType {
            noValue, singleValue, betweenValue, listValue
        }

        public Criterion() {
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

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public void setSecondValue(Object secondValue) {
            this.secondValue = secondValue;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getAndOr() {
            return andOr;
        }

        public void setAndOr(String andOr) {
            this.andOr = andOr;
        }

        public ValueType getValueType() {
            return valueType;
        }

        public void setValueType(ValueType valueType) {
            this.valueType = valueType;
        }
    }

    /**
     * 缓存实体类和表的映射关系
     *
     * @param entityClass
     */
    private void cacheEntityTable(Class<A> entityClass) {
        if (!entityTableCache.containsKey(entityClass)) {
            Table table = entityClass.getAnnotation(Table.class);
            Map<String, String> fieldsMap = new LinkedHashMap<>();
            Field[] declaredFields = entityClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(Column.class)) {
                    Column column = declaredField.getAnnotation(Column.class);
                    fieldsMap.put(declaredField.getName(), column.name());
                } else {
                    String s = StringUtils.convertByStyle(declaredField.getName(), StringUtils.Style.camelhump);
                    fieldsMap.put(declaredField.getName(), s);
                }
            }

            EntityTable entityTable = new EntityTable();
            entityTable.tableName = table.name();
            entityTable.fieldsMap = fieldsMap;

            entityTableCache.put(entityClass, entityTable);
        }
    }

    public Criteria() {
    }

    private Criteria(Class entityClass) {
        statement = new Statement();
        statement.criterions = new LinkedList();
        statement.clazz = entityClass;
    }

    public static <A, B> Criteria<A, B> of(Class<A> entityClass) {
        return new Criteria<>(entityClass);
    }

    public Criteria<A, B> page(Integer pageNum, Integer pageSize) {
        this.statement.pageNum = pageNum;
        this.statement.pageSize = pageSize;
        return this;
    }

    public Criteria<A, B> sort(Fn<A, B>... fns) {
        this.statement.sortNames = Reflections.fnToFieldName(fns);
        return this;
    }

    public Criteria<A, B> sortDesc(Fn<A, B>... fns) {
        this.statement.sortNames = Reflections.fnToFieldName(fns);
        this.statement.sortOrder = "desc";
        return this;
    }

    public Criteria<A, B> fields(Fn<A, B>... fns) {
        this.statement.fields = Reflections.fnToFieldName(fns);
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

    /**
     * 构建普通sql
     *
     * @return
     */
    public String buildSql() {
        cacheEntityTable(statement.clazz);
        StringBuilder sql = new StringBuilder("");
        sql.append(SqlHelper.selectColumns(statement));
        sql.append(SqlHelper.fromTable(statement));
        sql.append(SqlHelper.whereClause(statement));
        sql.append(SqlHelper.orderByClause(statement));
        sql.append(SqlHelper.limit(statement));
        return sql.toString();
    }

    /**
     * 构建统计的sql
     *
     * @return
     */
    public String buildCountSql() {
        cacheEntityTable(statement.clazz);
        StringBuilder sql = new StringBuilder("");
        sql.append(SqlHelper.selectCount(statement));
        sql.append(SqlHelper.fromTable(statement));
        sql.append(SqlHelper.whereClause(statement));
        return sql.toString();
    }

    public static class SqlHelper {

        public static String selectColumns(Statement statement) {
            StringBuilder selectColumns = new StringBuilder("select ");
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            if (statement.fields != null && statement.fields.length > 0) {
                List<String> columns = new ArrayList();
                for (Object fieldStr : statement.fields) {
                    columns.add(entityTable.fieldsMap.get(fieldStr));
                }
                return selectColumns.append(String.join(",", columns)).toString();
            } else {
                Map<String, String> fieldsMap = entityTable.fieldsMap;
                return selectColumns.append(fieldsMap.entrySet().stream()
                        .map(Map.Entry::getValue)
                        .collect(Collectors.joining(","))).toString();
            }
        }

        public static String selectCount(Statement statement) {
            return "select count(*)";
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
                        if (!(criterion.value instanceof Number || criterion.value instanceof Boolean)) {
                            criterion.value = "'".concat(criterion.value.toString()).concat("'");
                        }
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition + " " + criterion.value);
                    }
                    if (criterion.valueType == Criterion.ValueType.betweenValue) {
                        if (!(criterion.value instanceof Number || criterion.value instanceof Boolean)) {
                            criterion.value = "'".concat(criterion.value.toString()).concat("'");
                        }
                        if (!(criterion.secondValue instanceof Number || criterion.value instanceof Boolean)) {
                            criterion.secondValue = "'".concat(criterion.secondValue.toString()).concat("'");
                        }
                        whereClause.append(entityTable.fieldsMap.get(criterion.property) + " " + criterion.condition + " " + criterion.value + " AND " + criterion.secondValue);
                    }
                    if (criterion.valueType == Criterion.ValueType.listValue) {
                        Iterable iterable = (Iterable) criterion.value;
                        StringBuilder listItem = new StringBuilder();
                        for (Object o : iterable) {
                            if (!(o instanceof Number || criterion.value instanceof Boolean)) {
                                o = "'".concat(o.toString()).concat("'");
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
            if (statement.sortNames == null) {
                return "";
            }
            EntityTable entityTable = entityTableCache.get(statement.clazz);
            StringBuilder orderByClause = new StringBuilder();
            for (int i = 0; i < statement.sortNames.length; i++) {
                if (i == 0) {
                    orderByClause.append(" order by ");
                }
                orderByClause.append(entityTable.fieldsMap.get(statement.sortNames[i])).append(",");
            }
            if (orderByClause.length() > 0) {
                orderByClause.deleteCharAt(orderByClause.length() - 1);
            }
            if (statement.sortOrder != null) {
                orderByClause.append(" " + statement.sortOrder);
            }
            return orderByClause.toString();
        }

        public static String limit(Statement statement) {
            if (statement.pageSize > 0) {
                Integer offset = statement.pageSize;
                if (statement.pageNum > 1) {
                    Integer limit = (statement.pageNum - 1) * statement.pageSize;
                    return " limit " + limit + "," + offset;
                }
                return " limit " + offset;
            }
            return "";
        }

    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
