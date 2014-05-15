
package org.imie.service.promotion;

import java.util.List;

import javax.ejb.Local;

import model.Promotion;

@Local
public interface PromotionServiceLocal
{
	public List<Promotion> rechercherPromotion(Promotion promotion);
	public Promotion creerPromotion(Promotion promotionToCreate);
	public Promotion mettreAJourPromotion(Promotion promotionToUpdate);
	public void supprimerPromotion(Promotion promotion);
}
