
package org.imie.service.competence;

import java.util.List;

import javax.ejb.Local;

import model.Competence;
import model.Promotion;

@Local
public interface CompetenceServiceLocal
{
	public void test();

	public List<Competence> skillsTree(Boolean validated);

	public List<Promotion> lookForClass(Promotion promotion);

	public Promotion updateClass(Promotion promotionToUpdate);

	public Promotion createClass(Promotion promotionToCreate);
}