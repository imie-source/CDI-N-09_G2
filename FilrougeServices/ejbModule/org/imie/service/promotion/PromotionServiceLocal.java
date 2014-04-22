
package org.imie.service.promotion;

import java.util.List;

import javax.ejb.Local;

import model.Promotion;

@Local
public interface PromotionServiceLocal
{

	public List<Promotion> lookForClass(Promotion promotion);

	public Promotion updateClass(Promotion promotionToUpdate);

	public Promotion createClass(Promotion promotionToCreate);

}
