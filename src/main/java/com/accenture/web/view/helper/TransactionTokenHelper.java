package com.accenture.web.view.helper;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Input;
import org.mixer2.jaxb.xhtml.InputType;
import com.accenture.web.Const;

public class TransactionTokenHelper {
	
	 public static void addToken(HttpSession session, Form form) {

	        // create token
	        String transactionToken = DigestUtils.sha256Hex(String.valueOf(Math
	                .random()));

	        // set token to session
	        session.setAttribute(Const.transactionTokenAttributeName,
	                transactionToken);

	        // set hidden input tag having token into form
	        Input input = new Input();
	        input.setName(Const.transactionTokenAttributeName);
	        input.setType(InputType.HIDDEN);
	        input.setValue(transactionToken);
	        form.getContent().add(input);
	    }
	 public static boolean checkToken(HttpSession session,
	            String transactionToken) {
	        String token = (String) session
	                .getAttribute(Const.transactionTokenAttributeName);
	        if (StringUtils.isNotEmpty(token) && token.equals(transactionToken)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public static void removeToken(HttpSession session) {
	        session.removeAttribute(Const.transactionTokenAttributeName);
	    }


}
