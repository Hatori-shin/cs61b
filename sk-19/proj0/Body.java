public class Body {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Body(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double dx = Math.abs(this.xxPos - b.xxPos);
		double dy = Math.abs(this.yyPos - b.yyPos);
		double rr = Math.sqrt(dx * dx + dy * dy);
		return rr;
	}

	public double calcForceExertedBy (Body b) {
		double force;
		double r = this.calcDistance(b);
		force =  6.67 * Math.pow(10, -11) * this.mass * b.mass / (r * r);
		return force;
	}

}