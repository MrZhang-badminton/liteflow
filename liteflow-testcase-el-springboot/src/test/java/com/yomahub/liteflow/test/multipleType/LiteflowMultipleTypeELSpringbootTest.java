package com.yomahub.liteflow.test.multipleType;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 测试springboot下混合格式规则的场景
 * @author Bryan.Zhang
 * @since 2.5.10
 */
@RunWith(SpringRunner.class)
@TestPropertySource(value = "classpath:/multipleType/application.properties")
@SpringBootTest(classes = LiteflowMultipleTypeELSpringbootTest.class)
@EnableAutoConfiguration
@ComponentScan({"com.yomahub.liteflow.test.multipleType.cmp"})
public class LiteflowMultipleTypeELSpringbootTest extends BaseTest {

    @Autowired
    private FlowExecutor flowExecutor;

    @Test
    public void testMultipleType() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
        Assert.assertTrue(response.isSuccess());
        Assert.assertEquals("a==>b==>c==>b==>a", response.getExecuteStepStr());
        response = flowExecutor.execute2Resp("chain3", "arg");
        Assert.assertTrue(response.isSuccess());
        Assert.assertEquals("a==>b==>c", response.getExecuteStepStr());
    }
}
