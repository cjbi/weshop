package tech.wetech.weshop.user.fallback;

import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.dto.AddressDTO;
import tech.wetech.weshop.user.po.Address;

import java.util.List;

public class AddressApiFallback implements AddressApi {
    @Override
    public AddressDTO queryDetail(Integer id) {
        return null;
    }

    @Override
    public List<AddressDTO> queryDetailList() {
        return null;
    }

    @Override
    public List<Address> queryAll() {
        return null;
    }

    @Override
    public List<Address> queryList(Address entity) {
        return null;
    }

    @Override
    public Address queryOne(Address entity) {
        return null;
    }

    @Override
    public Address queryById(Object id) {
        return null;
    }

    @Override
    public int create(Address entity) {
        return 0;
    }

    @Override
    public int updateAll(Address entity) {
        return 0;
    }

    @Override
    public int updateNotNull(Address entity) {
        return 0;
    }

    @Override
    public int delete(Address entity) {
        return 0;
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    public int count(Address entity) {
        return 0;
    }
}
