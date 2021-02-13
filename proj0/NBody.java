class NBody {
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		Body[] bodys = new Body[numberOfPlanets]; 
		int i = 0;
		while(i < numberOfPlanets){
				double xPos = in.readDouble();
				double yPos = in.readDouble();
				double xVel = in.readDouble();
				double yVel = in.readDouble();
				double mass = in.readDouble();
				String img = in.readString();
				bodys[i] = new Body(xPos,yPos,xVel,yVel,mass,img);
				i++;
		}
		return bodys;
	}

	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		double time = 0;
		double T = Double.parseDouble(args[0]);

		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Body[] bodys = readBodies(filename);
		StdDraw.setScale(-radius, radius);

		for(time = 0; time < T; time = time + dt){
			double[] xForces = new double[bodys.length];
			double[] yForces = new double[bodys.length];
			for(int i = 0; i < bodys.length; i++){
				xForces[i] = bodys[i].calcNetForceExertedByX(bodys);
				yForces[i] = bodys[i].calcNetForceExertedByY(bodys);
			}

			for(int i = 0; i < bodys.length; i++){
				bodys[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			for(Body b :bodys){
				b.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", bodys.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodys.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodys[i].xxPos, bodys[i].yyPos, bodys[i].xxVel,
		                  bodys[i].yyVel, bodys[i].mass, bodys[i].imgFileName);   
		}
	}
}