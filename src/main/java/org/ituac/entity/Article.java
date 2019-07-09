package org.ituac.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

@Data
@Document(collection="t_sys_article_info")			//注释此类将被映射到数据库的一个集合（collection为集合名称）
public class Article implements Serializable{
	
	private static final long serialVersionUID = 3011652720162108352L;
	
	//标记id字段
	@Id
    private ObjectId id;
	
	//如果实体类没有为任何字段创建索引将不会自动创建集合 单字段索引（默认ASCENDING 升序、DESCENDING 降序）
	@Indexed(direction = DESCENDING)	
    @Field("title")
    private String title;
    
    @Field("url")				 //修改映射到数据库中的名称
    private String url;
    
    @Field("author")
    private String author;
    
    @Field("tags")
    private List<Integer> tags;
    
    @Field("visit_count")
    private Long visitCount;
    
    @Field("add_time")
    private Date addTime;
    
    @Transient
    private Integer count;
    
    

}
