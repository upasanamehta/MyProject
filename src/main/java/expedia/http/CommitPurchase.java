package expedia.http;

import com.expedia.e3.data.messagetypes.defn.v4.MessageInfoType;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchase.defn.v2.CommitPurchaseRequest;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchase.defn.v2.CommitPurchaseResponse;
import com.expedia.e3.ss.lodging.lodginginterface.messages.commitpurchasetypes.defn.v2.MessageBodyType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.joda.time.DateTime;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by umehta on 6/29/16.
 */

@RestController
public class CommitPurchase {

    private static final Logger logger = LogManager.getLogger(CommitPurchase.class);
    private final MinimalPrettyPrinter printer = new MinimalPrettyPrinter();

    @RequestMapping(value = "/mp/v1/CommitPurchase"  ,method = RequestMethod.POST  ,
            produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} ,
            consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public CommitPurchaseResponse commitPurchase (final CommitPurchaseRequest commitPurchaseRequest){



        CommitPurchaseResponse commitPurchaseResponse = new CommitPurchaseResponse();
        logger.info("hello");

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

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().with(printer);
        String req = null , rsp = null;
        try {
            req = ow.writeValueAsString(commitPurchaseRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(rsp !=null){
            try {
                rsp = ow.writeValueAsString(commitPurchaseResponse);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        logger.debug("Request : \n" , req);
        logger.debug("Response :\n" , rsp);


    }

}
