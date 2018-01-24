import numpy as np

a = np.array([15, 12, 8, 8, 7, 7, 7, 6, 5, 3])
b = np.array([10, 25, 17, 11, 13, 17, 20, 13, 9, 15]); 

print ('%.3f' % np.corrcoef(a, b)[1,0])
print(0.145)