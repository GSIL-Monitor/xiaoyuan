package com.project.xiaoyuan.mongodb;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

public class MongodbTest {

    //不通过认证获取连接数据库对象
    //public static MongoDatabase getConnect(){
        //连接到 mongodb 服务
        //MongoClient mongoClient = new MongoClient("localhost", 27017);

        //连接到数据库
        //MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        //返回连接数据库对象
        //return mongoDatabase;
    //}

    //需要密码认证方式连接
    //public static MongoDatabase getConnect2(){
        //List<ServerAddress> adds = new ArrayList<>();
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        //ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        //adds.add(serverAddress);

        //List<MongoCredential> credentials = new ArrayList<>();
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        //MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
        //credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接
        //MongoClient mongoClient = new MongoClient(adds, credentials);

        //连接到数据库
        //MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        //返回连接数据库对象
        //return mongoDatabase;
    //}

    @Test
    public void test2(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = mongoDatabase.getCollection("user");

        //增加
        Document document = new Document("name", "zhangshan").append("sex","nan").append("age",19);
        collection.insertOne(document);

        //删除
        //申明删除条件
        Bson filter = Filters.eq("age",18);
        //删除与筛选器匹配的单个文档
        collection.deleteOne(filter);
        //申明删除条件
        Bson filt = Filters.eq("age",18);
        //删除与筛选器匹配的所有文档
        collection.deleteMany(filt);

        //修改过滤器
        Bson filte = Filters.eq("name", "张三");
        //指定修改的更新文档
        Document document1 = new Document("$set", new Document("age", 100));
        //修改单个文档
        collection.updateOne(filte, document1);

        //修改过滤器
        Bson filterup = Filters.eq("name", "张三");
        //指定修改的更新文档
        Document document2 = new Document("$set", new Document("age", 100));
        //修改多个文档
        collection.updateMany(filterup, document2);

        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        //取出查询到的第一个文档
        Document document3 = (Document) findIterable.first();
        //打印输出
        System.out.println(document3);

    }

    @Test
    public void test1(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = mongoDatabase.getCollection("user");

        System.out.println(collection);
    }

}
