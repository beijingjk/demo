package com.jk.service.shopping;

import com.jk.mapper.mapper.ShoppMapper;
import com.jk.model.FruitsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppServiceImpl implements ShoppingServiceApi {

    @Autowired
    private ShoppMapper shoppMapper;

    @Override
    public List<FruitsInfo> queryFruitsInfo() {
        List<FruitsInfo> fruitsInfos = shoppMapper.queryFruitsInfo();
        return fruitsInfos;
    }

    @Override
    public void eidtOrderStatus(String id) {
        shoppMapper.eidtOrderStatus(id);
    }

}
