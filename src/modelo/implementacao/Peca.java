package modelo.implementacao;

public class Peca {
private Posicao pos;
private Integer num;

public Peca(Posicao pos, int num){
	this.pos=pos;
	this.num=num;
}
public int getNumero(){
	return this.num;
}
public void setNumero(Integer numero){
	this.num = numero;
}
public Integer getPosX(){
	return this.pos.getPosX();
}
public void setPosX(Integer posX){
	this.pos.setPosX(posX);
}
public Integer getPosY(){
	return this.pos.getPosY();
}
public void setPosY(Integer posY){
	this.pos.setPosY(posY);
}
public Posicao getPos(){
	return this.pos;
}
public void setPos(Posicao pos){
	this.pos=pos;
}
}
