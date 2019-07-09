package org.ituac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ituac.entity.Article;
import org.ituac.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 基本的mongodb常规操作
 * @author ituac
 */

@Controller
public class MongoController {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@GetMapping(value = "/insert")
	public Result insert(){
		Article article = new Article();
		article.setAuthor("波罗星");
		article.setCount(25);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(13);
		article.setTags(list);
		article.setTitle("mongo的常规使用");
		article.setUrl("/mongodb/base");
		article.setAddTime(new Date());
		mongoTemplate.insert(article);
		return new Result(200, true, "请求成功");
	}

}
