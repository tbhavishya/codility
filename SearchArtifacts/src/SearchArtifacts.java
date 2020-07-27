
public class SearchArtifacts {

	public int[] resution(int N, String artifacts, String searched) {

		int[] res = { 1, 1 };

		int count = 0, totalArtifactCells = 0; // totalArtifactCells stores the count of total number of cells an
												// artifact occupies, count is to count the hits in search string.

		String[] arrOfArtifacts = artifacts.split(",", (N * N)); // Total number of artifacts.

		String[] eachArtifact; // Co-ordinates of artifact.

		for (int i = 0; i < arrOfArtifacts.length; i++) {

			eachArtifact = arrOfArtifacts[i].split(" ", N); // Co-ordinates of current artifact stored in array.

			count = 0;

			totalArtifactCells = 0;

			for (char j = eachArtifact[0].charAt(0); j <= eachArtifact[1].charAt(0); j++) {

				for (char k = eachArtifact[0].charAt(1); k <= eachArtifact[1].charAt(1); k++) {

					totalArtifactCells++;

					if (searched.contains("" + j + k)) {

						count++;

					}

				}

			}

			if (count == totalArtifactCells) {

				res[0]++; // increment if all cells of current artifact is found.

			}

			else {

				if (count != 0) {

					res[1]++; // increment if not all but some are found.

				}

			}

		}

		return res;

	}

	public static void main(String[] args) {

		int[] res = new int[2];

		int N;

		String artifacts, searched;

		SearchArtifacts SA = new SearchArtifacts();

		// modify below values of N, artifacts and searched before passing them to the
		// function resution().

		N = 3;

		artifacts = "4A 3B,4C 2C";

		searched = "1B";

		if (N > 26 || N < 1) {

			System.out.println("N should be between 1 and 26.");

			System.exit(0);

		}

		res = SA.resution(N, artifacts, searched);

		System.out.println("resution : [" + res[0] + "," + res[1] + "]."); // Print Result

	}

}
