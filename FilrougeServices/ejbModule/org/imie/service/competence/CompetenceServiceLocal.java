
package org.imie.service.competence;

import java.util.List;

import javax.ejb.Local;

import model.Competence;

@Local
public interface CompetenceServiceLocal
{
	public void test();

	public List<Competence> skillsTree(Boolean validated);
}
