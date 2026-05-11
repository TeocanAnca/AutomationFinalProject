package base;

import config.BaseConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private Logger Logger;
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected RequestSpecification requestSpecification;

    @BeforeClass
    public void setApiConfig(){
        RestAssured.baseURI = BaseConfig.BASE_URL;

        requestSpecification = new RequestSpecificationBuilder()
                .addHeaders(BaseConfig.getDefaultHeaders())
                .setRelaxedHTTPSValidation()
                .build();
        log.info("Configured with base" + RestAssured.baseURI);
    }

}
