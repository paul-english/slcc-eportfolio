/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamictimewarpingexample;

//import weka.classifiers.functions.pace.Matrix;
import java.util.*;
import weka.core.matrix.Matrix;

/**
 * Reference : ---------- Chapter 8 of "Pattern Recognition" (2nd Ed.) by S.
 * Theodoridis and K. Koutroumbas, published by Academic Press.
 */
public class DynamicTimeWarping
{

	private Matrix targetTimeSeries;
	private ArrayList otherInstancesTimeSeries;
	private Hashtable timeSeriesRanking;

	/**
	 *
	 * @param target Matrix
	 */
	public DynamicTimeWarping(Matrix target)
	{
		this.targetTimeSeries = target;
		otherInstancesTimeSeries = new ArrayList();
		timeSeriesRanking = new Hashtable();
	}

	/**
	 *
	 * @param otherInstances Collection
	 */
	public void addOtherInstancesTimeSeries(Collection otherInstances)
	{
		otherInstancesTimeSeries.addAll(otherInstances);
	}

	/**
	 *
	 * @param instanceTimeSeries Matrix
	 */
	public void addOneInstancesTimeSeries(Matrix instanceTimeSeries)
	{
		otherInstancesTimeSeries.add(instanceTimeSeries);
	}

	/**
	 *
	 * @param newTargetTimeSeries Matrix
	 */
	public void setTargetTimeSeries(Matrix newTargetTimeSeries)
	{
		this.targetTimeSeries = newTargetTimeSeries;
	}

	/**
	 *
	 */
	public void removeAllOtherInstancesTimeSeries()
	{
		otherInstancesTimeSeries.clear();
	}

	/**
	 *
	 * @throws Exception
	 */
	public void computeDTW() throws Exception
	{
		if (otherInstancesTimeSeries.isEmpty())
		{
			throw new Exception("computeDTW : Empty collections of time-series.");
		}
		timeSeriesRanking.clear();
		int count = 0;
		Iterator iter = otherInstancesTimeSeries.iterator();
		while (iter.hasNext())
		{
			count++;
			Matrix instanceTimeSeries = (Matrix) iter.next();
			dtwMain(instanceTimeSeries, count);
		}
	}//end method

	/**
	 *
	 * @param otherInstanceTimeSeries Matrix
	 * @param count int
	 */
	private void dtwMain(Matrix otherInstanceTimeSeries, int count)
	{
		int MM = targetTimeSeries.getColumnDimension();
		int NN = otherInstanceTimeSeries.getColumnDimension();

		Matrix d = new Matrix(MM, NN);
		Matrix D = new Matrix(MM, NN);
		double val = 0.0;

		for (int m = 0; m < MM; m++)
		{
			for (int n = 0; n < NN; n++)
			{
				val = targetTimeSeries.get(0, m) - otherInstanceTimeSeries.get(0, n);
				d.set(m, n, val * val);
			}
		}

		D.set(0, 0, d.get(0, 0));

		for (int m = 1; m < MM; m++)
		{
			val = d.get(m, 0) + D.get(m - 1, 0);
			D.set(m, 0, val);
		}

		for (int n = 1; n < NN; n++)
		{
			val = d.get(0, n) + D.get(0, n - 1);
			D.set(0, n, val);
		}

		for (int m = 1; m < MM; m++)
		{
			for (int n = 1; n < NN; n++)
			{
				val = Math.min(Math.min(D.get(m - 1, n), D.get(m - 1, n - 1)), D.get(m, n - 1));
				val += d.get(m, n);
				D.set(m, n, val);
			}
		}

		double Dist = D.get(MM - 1, NN - 1);
		int m = MM - 1;
		int n = NN - 1;
		double k = 1.0;
		int ind = 1;

		while ((m + n) != 0)
		{
			if (m == 0)
			{
				n = n - 1;
			}
			else if (n == 0)
			{
				m = m - 1;
			}
			else
			{
				//an alternative here is to change into 5 points warping instead of 3 points.
				double[] arr =
				{
					D.get(m - 1, n), D.get(m, n - 1), D.get(m - 1, n - 1)
				};
				ind = indexOfArrayMinimum(arr);
				if (ind == 0)
				{
					m = m - 1;
				}
				else if (ind == 1)
				{
					n = n - 1;
				}
				else if (ind == 2)
				{
					m = m - 1;
					n = n - 1;
				}
			}
			k = k + 1.0;
		}//end while

		timeSeriesRanking.put("Time Series - " + count, new Double(Dist / k));
	}//end method

	/**
	 *
	 * @return HashMap
	 */
	public Hashtable getTimeSeriesRanking()
	{
		return timeSeriesRanking;
	}

	/**
	 *
	 * @param arr double[]
	 * @return int index of the minimum value
	 */
	private int indexOfArrayMinimum(double[] arr)
	{
		int len = arr.length;
		int ind = 0;
		double val = arr[0];
		for (int i = 1; i < len; i++)
		{
			if (arr[i] < val)
			{
				val = arr[i];
				ind = i;
			}
		}
		return ind;
	}

	public static void main(String[] args)
	{
		//NOTE :  time-series can have different lengths
		Matrix t = new Matrix(new double[][]
			{
				{
					19, 5, 12, 10,
					18, 15, 9
				}
			});

		Matrix r1 = new Matrix(new double[][]
			{
				{
					0, 16, 9, 12,
					16, 18, 15
				}
			});
		Matrix r2 = new Matrix(new double[][]
			{
				{
					4, 8, 19, 18,
					8, 18, 1
				}
			});
		Matrix r3 = new Matrix(new double[][]
			{
				{
					7, 16, 0, 3,
					4, 4, 12
				}
			});

		DynamicTimeWarping dtw = new DynamicTimeWarping(t);
		ArrayList arrayList = new ArrayList();
		arrayList.add(r1);
		arrayList.add(r2);
		arrayList.add(r3);

		dtw.addOtherInstancesTimeSeries(arrayList);
		try
		{
			dtw.computeDTW();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		Hashtable map = dtw.getTimeSeriesRanking();
		Double dbl1 = (Double) map.get("Time Series - 1");
		System.out.println("s1 = " + dbl1);
		Double dbl2 = (Double) map.get("Time Series - 2");
		System.out.println("s2 = " + dbl2);
		Double dbl3 = (Double) map.get("Time Series - 3");
		System.out.println("s3 = " + dbl3);
	}
}