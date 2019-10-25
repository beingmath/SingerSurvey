package entry;

public class aCCstep {
   int acc;//1代表点了，0代表没点
   int step;
public int getAcc() {
	return acc;
}
public void setAcc(int acc) {
	this.acc = acc;
}
public int getStep() {
	return step;
}
public void setStep(int step) {
	this.step = step;
}
public aCCstep(int acc, int step) {
	super();
	this.acc = acc;
	this.step = step;
}
public aCCstep() {
	super();
}
}
