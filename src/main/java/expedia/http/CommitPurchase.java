package expedia.http;

import com.expedia.e3.data.messagetypes.defn.v4.MessageInfoType;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchase.defn.v2.CommitPurchaseRequest;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchase.defn.v2.CommitPurchaseResponse;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchasetypes.defn.v2.MessageBodyType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.joda.time.DateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by umehta on 6/29/16.
 */

@RestController
public class CommitPurchase {

    private static final Logger logger = LoggerFactory.getLogger("myLogger");
    private final MinimalPrettyPrinter printer = new MinimalPrettyPrinter();

    @RequestMapping(value = "/mp/v1/CommitPurchase"  ,method = RequestMethod.POST  ,
            produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} ,
            consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public CommitPurchaseResponse commitPurchase ( @RequestBody @Valid final CommitPurchaseRequest commitPurchaseRequest){



        CommitPurchaseResponse commitPurchaseResponse = new CommitPurchaseResponse();
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");

        System.out.println(commitPurchaseRequest.getBookingRecordID());

        MessageBodyType messageBody = new MessageBodyType();
        messageBody.setAcknowledged(true);
        commitPurchaseResponse.setMessageBody(messageBody);
        commitPurchaseResponse.setMessageError(null);
        MessageInfoType messageInfo = new MessageInfoType();
        messageInfo.setMessageNameString("Commit");
        messageInfo.setMessageVersion("2.0");
        messageInfo.setEndUserIPAddress("123.567.2.34");
        messageInfo.setCreateDateTime(new DateTime());
        messageInfo.setActivityGUID("abc");
        messageInfo.setClientHostnameString("abc");
        messageInfo.setDebugTraceBoolean(true);
        messageInfo.setClientName("upi");

        commitPurchaseResponse.setMessageInfo(messageInfo);
        logReqRsp(commitPurchaseRequest , commitPurchaseResponse);

        return commitPurchaseResponse;
    }

    private void logReqRsp(CommitPurchaseRequest commitPurchaseRequest, CommitPurchaseResponse commitPurchaseResponse) {

        // XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper mapper = new XmlMapper();
        // ObjectWriter ow = mapper.writer(SerializationFeature.INDENT_OUTPUT);
        // mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //ObjectWriter ow = mapper.writer().with();
        String req = null ;
        String rsp = null;
        try {
            req = mapper.writeValueAsString(commitPurchaseRequest);
            //req = ow.writeValueAsString(commitPurchaseRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        try {
            rsp = mapper.writeValueAsString(commitPurchaseResponse);
            // rsp = ow.writeValueAsString(commitPurchaseResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        logger.info("Request :  \n {}" , req);
        logger.info("Response :\n {}" , rsp);


    }

}
