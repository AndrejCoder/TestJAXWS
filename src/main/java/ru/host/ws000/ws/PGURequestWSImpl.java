package ru.host.ws000.ws;

import ru.host.ws000.bean.MessageType;
import ru.host.ws000.bean.RegisterResponseType;
import ru.host.ws000.bean.ServiceMessageDataType;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.host.ws000.ws.PGURequestWS", serviceName = "PGURequestWS")
public class PGURequestWSImpl implements PGURequestWS {

	@Override
	public RegisterResponseType registerRequest(MessageType message, ServiceMessageDataType messageData) {
//        MessageType srcMessage = null;
//        try {
//            try {
//                srcMessage = request.getMessage();
//                MessageInfo messageInfo = getMessageInfo(messageContext, srcMessage);
//                RegisterPGURequestComposite pguRequest = fromRequest(request, messageInfo);
////                RegisterPGUResponseComposite response = pguService.reqisterRequest(pguRequest);
//                result = buildRequestResponseProxied(response, messageInfo, null);
//            } catch (PGUExceptions.BaseException e) {
//                logger.severe(e.getDescription());
//                throw e;
//            } catch (Exception e) {
//                logger.log(Level.SEVERE, "Internal error", e);
//                throw new PGUExceptions.InternalError();
//            }
//        } catch (PGUExceptions.BaseException e) {
//            if (srcMessage != null) {
//                try {
//                    MessageInfo messageInfo = getMessageInfo(messageContext, srcMessage);
//                    result = buildRequestResponseProxied(null, messageInfo, buildErrorBlock(e));
//                } catch (Exception ex) {
//                    logger.log(Level.SEVERE, "Ошибка при формировании ошибки", ex);
//                    throw e;
//                }
//            } else {
//                throw e;
//            }
//        }
        RegisterResponseType result = new RegisterResponseType();
        MessageType msg = new MessageType();
        msg.setExchangeType(message.getOriginator().getName());
        result.setMessage(msg);
        return result;
    }
}