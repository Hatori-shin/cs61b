public class NBody {

	public static double readRadius(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double rOfUniverse = in.readDouble();
		return rOfUniverse;
	}

	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		Body[] allBodys = new Body[N];
		for (int i = 0; i < N; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			allBodys[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return allBodys;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radOfUniverse = readRadius(filename);
		Body[] allBodys = readBodies(filename);

		
		String imageToDraw = "images/starfield.jpg";

		StdDraw.setXscale(-radOfUniverse, radOfUniverse);
		StdDraw.setYscale(radOfUniverse, -radOfUniverse); 

		StdDraw.picture(0, 0, imageToDraw);

		for (Body object: allBodys){
			object.draw();
		}

	}

}