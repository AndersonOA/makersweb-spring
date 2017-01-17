/**
 * 
 */
package br.com.makersweb.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;

import br.com.makersweb.domain.DefaultDomain;
import br.com.makersweb.util.MakersUtils;

/**
 *
 * @author anderson.aristides
 *
 */
public class AspectDao {
	
	public Object doBasicDomainInformation(ProceedingJoinPoint pjp) throws Throwable {
		Object myEntity = pjp.getArgs()[0];
		if (myEntity instanceof DefaultDomain) {
			myEntity = setDefaultValues((DefaultDomain) myEntity);
		}
		Object retVal = pjp.proceed();
		return retVal;
	}

	private DefaultDomain setDefaultValues(DefaultDomain defaultDomain) {
		if (defaultDomain.getId() != null) {
			defaultDomain.setAtualizado(LocalDateTime.now());
			defaultDomain.setAtualizadoPor(this.getUser());
		} else {
			defaultDomain.setCriado(LocalDateTime.now());
			defaultDomain.setCriadoPor(this.getUser());
		}
		return defaultDomain;
	}

	private String getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email;
		if (!ObjectUtils.isEmpty(auth) && !auth.getName().equals(MakersUtils.USER_ANONYMOUS)) {
			email = auth.getName();
		} else {
			email = MakersUtils.EMAIL_SUPORTE;
		}
		return email;

	}

}
