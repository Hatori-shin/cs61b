class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double gravitational = 6.67e-11;

	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance (Body b){
		double dxPos = b.xxPos - this.xxPos;
		double dyPos = b.yyPos - this.yyPos;
		double distance = Math.sqrt(dxPos * dxPos + dyPos * dyPos);
		return distance;
	}

	public double calcForceExertedBy (Body b){
		double distance = calcDistance(b);
	    double force = (gravitational * b.mass * this.mass) / (distance * distance);
		return force;
	}

	public double calcForceExertedByX (Body b){
	    double force = calcForceExertedBy(b);
	    double r = calcDistance(b);
	    double xxForce = force * (b.xxPos - this.xxPos) / r;
		return xxForce;
	}

	public double calcForceExertedByY (Body b){
	    double force = calcForceExertedBy(b);
	    double r = calcDistance(b);
	    double yyForce = force * (b.yyPos - this.yyPos)  / r;
		return yyForce;
	}

	public double calcNetForceExertedByX (Body[] allBodys){
		double fxNet = 0;
		for(Body b : allBodys){
			if(!this.equals(b)){
				fxNet += calcForceExertedByX(b);
			}
		}
		return fxNet;	
	}

	public double calcNetForceExertedByY (Body[] allBodys){
		double fyNet = 0;
		for(Body b : allBodys){
			if(!this.equals(b)){
				fyNet += calcForceExertedByY(b);
			}
		}
		return fyNet;	
	}

	public void update(double dt, double fX, double fY){
		double xxAcc = fX / this.mass;
		double yyAcc = fY / this.mass;
		this.xxVel += dt * xxAcc ;
		this.yyVel += dt * yyAcc;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
			
	}

	public void draw(){
		String img = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, img);
	}
}