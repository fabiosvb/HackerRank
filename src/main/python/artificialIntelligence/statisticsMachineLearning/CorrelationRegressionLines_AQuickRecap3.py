from scipy import stats
import numpy as np

a = np.array([15, 12, 8, 8, 7, 7, 7, 6, 5, 3])
b = np.array([10, 25, 17, 11, 13, 17, 20, 13, 9, 15])

slope, intercept, r_value, p_value, std_err = stats.linregress(a,b)

print ((slope * 10) + intercept)
print ('%.3f' % 15.4583333333)
print (15.458) 