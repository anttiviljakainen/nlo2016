# Penalty function

import numpy as np

def f_constrained(x):
    return x[0] ** 2 + x[1] ** 2 + x[0] + 2 * x[1], [], [x[0] + x[1] - 1]
    
def alpha(x, f):
    (_, ieq, eq) = f(x)
    return sum([min([0, ieq_j]) ** 2 for ieq_j in ieq]) + sum([eq_k ** 2 for eq_k in eq])
    
def penalized_function(x, f, r):
    return f(x)[0] + r * alpha(x, f)
    
from scipy.optimize import minimize
res = minimize(lambda x : penalized_function(x, f_constrained, 100000),
               [0, 0], method = 'Nelder-Mead', options={'disp': True})
print(res.x)
