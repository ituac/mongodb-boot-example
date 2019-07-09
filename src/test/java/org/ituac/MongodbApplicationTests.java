package org.ituac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.ituac.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void initMogodb() {
		//循环添加
	    for (int i = 0; i < 10; i++) {
	        Article article = new Article();
	        article.setTitle("MongoTemplate的基本使用");
		    article.setAuthor("yinjihuan");
		    article.setUrl("http://cxytiandi.com/blog/detail/" + i);
		    article.setVisitCount(0L);
		    article.setAddTime(new Date());
		    mongoTemplate.save(article);
	    }
	    
	    //批量添加
	    List<Article> articles = new ArrayList<>(10);
	    for (int i = 0; i < 10; i++) {
		    Article article = new Article();
		    article.setTitle("MongoTemplate的基本使用");
		    article.setAuthor("yinjihuan");
		    article.setUrl("http://cxytiandi.com/blog/detail/" + i);
		    article.setVisitCount(0L);
		    article.setAddTime(new Date());
		    articles.add(article);
	    }
	    mongoTemplate.insert(articles, Article.class);
	    //mongoTemplate.dropCollection(Article.class);
	}
	

}
