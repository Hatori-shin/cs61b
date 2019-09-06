public class Body {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	final static double GRAV = 6.67e-11;

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
		force =  GRAV * this.mass * b.mass / (r * r);
		return force;
	}

	public double calcForceExertedByX (Body b) {
		double dx = b.xxPos - this.xxPos;
		double r = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double Fx = force * dx / r;
		return Fx;
	}

	public double calcForceExertedByY (Body b) {
		double dy = b.yyPos - this.xxPos;
		double r = this.calcDistance(b);
		double force = this.calcForceExertedBy(b);
		double Fy = force * dy / r;
		return Fy;
	}

	public double calcNetForceExertedByX (Body[] allBodys) {
		double fxSum = 0;
		for (Body object: allBodys){
			if (this.equals(object)){
				continue;
			}
			double fx = this.calcForceExertedByX(object);
			fxSum += fx;
		}
		return fxSum;
	}

	public double calcNetForceExertedByY (Body[] allBodys) {
		double fySum = 0;
		for (Body object: allBodys){
			if (this.equals(object)){
				continue;
			}
			double fy = this.calcForceExertedByY(object);
			fySum += fy;
		}
		return fySum;
	}

	public void update (double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;

	}

	public void draw() {
	    String imageToDraw = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
	}



}