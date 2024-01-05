class Tv2 {
	boolean power; // 전원상태(on/off)
	int channel; // 채널

	void power() {
		power = !power;
	}
}

class VCR {
	boolean power;
	int counter = 0;

	void power() {
		power = !power;
	}

	void play() {

	}

	void stop() {

	}

	void rew() {

	}

	void ff() {

	}
}

public class TVCR extends Tv2 {
	VCR vcr = new VCR();

	void play() {
		vcr.play();
	}

	void stop() {
		vcr.stop();
	}

	void rew() {
		vcr.rew();
	}

	void ff() {
		vcr.ff();
	}
}
