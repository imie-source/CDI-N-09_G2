
package org.imie.service.promotion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
@LocalBean
public class PromotionService implements PromotionServiceRemote,
		PromotionServiceLocal
{

	/**
	 * Default constructor.
	 */
	public PromotionService()
	{
		// TODO Auto-generated constructor stub
	}

}
