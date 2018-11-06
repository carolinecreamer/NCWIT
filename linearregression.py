'''
 linearregression.py

 Graph of linear regression using pandas, os, matplotlib, and numpy libraries.
 
 Copyright © 2018 Caroline Creamer. All rights reserved. 
'''


import pandas as pd
import os
import matplotlib.pyplot as plt
import numpy as np 

if "momentum_data.csv" not in os.listdir("."):
	df = pd.read_excel('momentum_data.xlsx')
	df.to_csv('momentum_data.csv', index=False)
df = pd.read_csv('momentum_data.csv', header=1)

p_before = list(df["Total p Before"])
p_before = [p for p in p_before if not np.isnan(p)]
p_after = list(df["Total p After"])
p_after = [p for p in p_after if not np.isnan(p)]

m = 0
b = 0

for i in range(2000):
	for (x,y) in zip(p_before, p_after):
		y_h = m*x+b
		J = (y - y_h)**2
		m -= -2*((y - y_h)*x) * 0.001
		b -= -2*(y - y_h) * 0.001

plt.scatter(p_before, p_after)
plt.plot(p_before, [m*x+b for x in p_before])
plt.show()

