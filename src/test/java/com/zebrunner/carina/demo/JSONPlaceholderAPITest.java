package com.zebrunner.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import jsonplaceholderapi.DeletePostMethod;
import jsonplaceholderapi.GetPostsMethod;
import jsonplaceholderapi.PostPostMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;


public class JSONPlaceholderAPITest implements IAbstractTest {

private static final Logger LOGGER=LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

@Test()
@MethodOwner(owner = "luke")
public void testCreatePost()throws Exception{
        PostPostMethod api=new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        AtomicInteger counter=new AtomicInteger(0);

        api.callAPIWithRetry()
        .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
        .peek(rs->counter.getAndIncrement())
        .until(rs->counter.get()==4)
        .pollEvery(1,ChronoUnit.SECONDS)
        .stopAfter(10,ChronoUnit.SECONDS)
        .execute();
        api.validateResponse();
        }

@Test()
@MethodOwner(owner = "luke")
public void testCreatePostMissingSomeFields()throws Exception{
        PostPostMethod api=new PostPostMethod();
        api.setProperties("api/posts/post.properties");
        api.getProperties().remove("title");
        api.getProperties().remove("body");
        api.callAPIExpectSuccess();
        api.validateResponse();
        }

@Test()
@MethodOwner(owner = "luke")
public void testGetPosts(){
        GetPostsMethod getPostsMethod=new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        getPostsMethod.validateResponse(JSONCompareMode.STRICT,JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostsMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
        }

@Test()
@MethodOwner(owner = "luke")
public void testDeletePost(){
        DeletePostMethod deletePostMethod=new DeletePostMethod();
        deletePostMethod.setProperties("api/posts/post.properties");
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
        }
        }
