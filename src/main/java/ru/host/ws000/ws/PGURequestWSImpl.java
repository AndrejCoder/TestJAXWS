package ru.host.ws000.ws;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.host.ws000.bean.MessageInfo;
import ru.host.ws000.bean.MessageType;
import ru.host.ws000.bean.RegisterResponseType;
import ru.host.ws000.bean.ServiceMessageDataType;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "ru.host.ws000.ws.PGURequestWS", serviceName = "PGURequestWS")
@HandlerChain(file= "/handler-chain.xml")
public class PGURequestWSImpl implements PGURequestWS {

    @Resource
    WebServiceContext ctx;

	@Override
	public RegisterResponseType registerRequest(MessageType message, ServiceMessageDataType messageData) {
        MessageInfo messageInfo = null;
        try {
            try {
                MessageContext mctx = ctx.getMessageContext();
                messageInfo = getMessageInfo((SOAPMessage) mctx.get("SOAPMessage"), message);
//                RegisterPGURequestComposite pguRequest = fromRequest(request, messageInfo);
//                RegisterPGUResponseComposite response = pguService.reqisterRequest(pguRequest);
//                result = buildRequestResponseProxied(response, messageInfo, null);
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        RegisterResponseType result = new RegisterResponseType();
        MessageType msg = new MessageType();
        msg.setExchangeType(message.getOriginator().getName());
        result.setMessage(msg);
        return result;
    }

    private MessageInfo getMessageInfo(SOAPMessage soapMessage, MessageType srcMessage) throws Exception {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setSrcMessage(srcMessage);
        messageInfo.setMessageId(String.valueOf(0));

//        SOAPMessage msg = messageContext.getMessage();
        NodeList headers = soapMessage.getSOAPHeader().getChildNodes(); // FIXME уж больно на низком уровне

        for (int i = 0; i < headers.getLength(); i++) {
            Node headerNode = headers.item(i);
            if (headerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element header = (Element) headerNode;
                if (header.getLocalName().equals("Header")) {
                    Node childNode = header.getFirstChild();
                    while (childNode != null) {
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element child = (Element) childNode;
                            if (child.getLocalName().equals("MessageId")) {
                                messageInfo.setMessageId(child.getFirstChild().getNodeValue());
                                return messageInfo;
                            }
                        }
                        childNode = childNode.getNextSibling();
                    }
                }
            }
        }
        return messageInfo;
    }
}