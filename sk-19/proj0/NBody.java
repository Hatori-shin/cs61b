public class NBody {

	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int N = in.readInt();
		double rOfUniverse = in.readDouble();
		return rOfUniverse;
	}

	public static Body[] readBodies(String fileName) {
		In in = new In(fileName);
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

}