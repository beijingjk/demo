package com.jk.controller.fruits;

import com.jk.model.FruitsInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("fruits")
public class FruitsController {

    /*未集群*/
    @Autowired
    private SolrClient client;

    @Autowired
    private CloudSolrClient cloudSolrClient;



    @RequestMapping("SearchFruits")
    public List<FruitsInfo> SearchFruits(String title) throws IOException, SolrServerException {
        List<FruitsInfo> list=new ArrayList<>();
        SolrQuery params = new SolrQuery();
        if(title!=""){
            params.set("q", title);
        }else{
            params.set("q", "*:*");
        }
        params.set("df", "title");
        params.set("fl", "id,title,price,img1");

        //排序
        params.addSort("id", SolrQuery.ORDER.asc);

        params.addHighlightField("title"); // 高亮字段


        //高亮
        //打开开关
        params.setHighlight(true);
        //设置前缀
        params.setHighlightSimplePre("<font color='red'>");
        //设置后缀
        params.setHighlightSimplePost("</font>");
        QueryResponse queryResponse = cloudSolrClient.query("core2",params);
        SolrDocumentList results = queryResponse.getResults();
        int numFound = (int) results.getNumFound();
        //System.out.println(numFound);
        Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
        int i=0;
        for (SolrDocument result : results) {
            FruitsInfo test1=new FruitsInfo();
            String highname="";
            Map<String, List<String>> map = highlight.get(result.get("id"));
            List<String> list2 = map.get("title");
            if(list2==null){
                highname=(String)result.get("title");
            }else{
                highname=list2.get(i);
            }
            /*String id = (String) result.get("id");
            test1.setId();*/
            test1.setImg2((String)result.get("id"));
            test1.setPresent((String)result.get("price"));
            test1.setTitle(highname);
            /*BigDecimal price = (BigDecimal) result.get("price");
            test1.setPrice(price);*/
            test1.setImg1((String)result.get("img1"));
            list.add(test1);
            i++;
        }
        return list;
    }

}
