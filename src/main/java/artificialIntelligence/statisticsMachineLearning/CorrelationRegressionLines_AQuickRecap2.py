from scipy import stats

a = np.array([15, 12, 8, 8, 7, 7, 7, 6, 5, 3])
b = np.array([10, 25, 17, 11, 13, 17, 20, 13, 9, 15])

slope, intercept, r_value, p_value, std_err = stats.linregress(a,b)

print ('%.3f' % slope)
print (0.208)