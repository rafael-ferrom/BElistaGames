package com.devsuperior.dslist.projections;

public interface GameMinProjection {
	//inserir metodos get correspondentes ao da minha consulta
	
	Long getId(); //inserir os metodos que temos la no sql
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
