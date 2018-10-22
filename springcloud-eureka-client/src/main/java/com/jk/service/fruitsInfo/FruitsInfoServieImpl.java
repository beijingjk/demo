package com.jk.service.fruitsInfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.fruitsInfo.FruitsInfoMapper;
import com.jk.model.Coupon;
import com.jk.model.FruitsInfo;
import com.jk.util.ConstantConf;
import com.jk.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FruitsInfoServieImpl implements FruitsInfoServieApi {

    @Autowired
    private FruitsInfoMapper fruitsInfoMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*
     *  薛长欢
     *
     *  根据商品id查询信息
     */
    @Override
    public FruitsInfo queryFruitsInfoById(Integer fruitsId) {
        return fruitsInfoMapper.queryFruitsInfoById(fruitsId);
    }

    /*
     *  薛长欢
     *
     *  根据登录人id查询优惠券
     */
    @Override
    public List<Coupon> queryConponByUserId(String loginId) {
        return fruitsInfoMapper.queryConponByUserId(loginId);
    }

    /*
     *  薛长欢
     *
     *  随机查询三条数据
     */
    @Override
    public List<FruitsInfo> queryFruitsInfoRandom() {
        return fruitsInfoMapper.queryFruitsInfoRandom();
    }

    /*
     *  薛长欢
     *
     *  加入购物车
     */
    @Override
    public Map<String, Object> addCart(String loginId, Integer fruitsId, Integer num) {
        //返回map
        Map<String, Object> result = new HashMap<>();
        //定义缓存key  由常量key+用户id+商品id组成
        String cacheKey = ConstantConf.REDIS_CART_KEY+":"+loginId+","+fruitsId;
        //根据key从redis中取数据
        String fruitsKey = redisTemplate.opsForValue().get(cacheKey);
        //判断商品是否存在
        //如果存在则数量相加
        if (fruitsKey != null){
            //将数据转换成对象  使用工具类
            FruitsInfo fruitsInfo = JsonUtils.jsonToPojo(fruitsKey, FruitsInfo.class);
            //数量相加
            fruitsInfo.setAmount(fruitsInfo.getAmount()+num);
            redisTemplate.opsForValue().set(cacheKey,JsonUtils.objectToJson(fruitsInfo));
            //flag为标识符  1 用户未登录 2 为商品信息存在数量加或减 3 商品不存在添加redis然后返回
            result.put("flag","2");
            return result;
        }
        //如果不存在根据商品id取出该商品
        FruitsInfo fruitsInfo = fruitsInfoMapper.queryFruitsInfoById(fruitsId);
        //set数量
        fruitsInfo.setAmount(num);
        //存进redis   JsonUtils.objectToJson是一个工具类 用于转换json
        redisTemplate.opsForValue().set(cacheKey,JsonUtils.objectToJson(fruitsInfo));
        //flag标识
        result.put("flag","3");
        return result;
    }

    @Override
    public List<FruitsInfo> queryCartList(String loginId) {
        //定义缓存key  由常量key+用户id+商品id组成
        String cacheKey = ConstantConf.REDIS_CART_KEY+":"+loginId;
        Set<String> keys = redisTemplate.keys(cacheKey+"*");
        List<FruitsInfo> fruitsInfos = new ArrayList<>();
        for (String fruitsKey: keys) {
            String s = redisTemplate.opsForValue().get(fruitsKey);
            FruitsInfo fruitsInfo = JsonUtils.jsonToPojo(s, FruitsInfo.class);
            fruitsInfos.add(fruitsInfo);
        }
        return fruitsInfos;
    }

}
