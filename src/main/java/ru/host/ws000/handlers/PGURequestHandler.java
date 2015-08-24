package ru.host.ws000.handlers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PGURequestHandler implements SOAPHandler<SOAPMessageContext> {
    private Exception signatureException;

    private final Logger logger = Logger.getLogger("SignatureInterceptor");

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty) {
            System.out.println("\nOutbound message:");
        } else {
            System.out.println("\nInbound message:");
        }
        SOAPMessage sm = context.getMessage();
        try {
            context.put("SOAPMessage", sm);
            context.setScope("SOAPMessage", MessageContext.Scope.APPLICATION);
            boolean isValid = true;
            try {
                Document doc = sm.getSOAPPart().getEnvelope().getOwnerDocument();
                isValid = true; //securityService.verifyDocument(doc);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception while verifing the document", e);
                throw signatureException;
            }
            if (!isValid) {
                throw signatureException;
            }
            return true;
        } catch (Exception e) {
            throw new ProtocolException(e);
        }
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
