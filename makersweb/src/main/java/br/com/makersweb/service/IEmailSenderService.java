/**
 * 
 */
package br.com.makersweb.service;

import java.util.Map;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IEmailSenderService {

	Boolean sendTestEmail(String email, Map<String, Object> data);
}
