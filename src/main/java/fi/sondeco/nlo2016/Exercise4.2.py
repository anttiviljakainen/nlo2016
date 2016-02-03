# Barrier method

import numpy as np

def f_constrained(x):
    return x[0] ** 2 + x[1] ** 2 + x[0] + 2 * x[1], [x[0] + x[1] - 0.8, 1.2 - (x[0] + x[1])], []
    
def beta(x, f):
    _,ieq,_ = f(x)
    try:
        value = sum([1 / max([0, ieq_j]) for ieq_j in ieq])
    except ZeroDivisionError:
        value = float("inf")
    return value
        
def function_with_barrier(x, f, r):
    return f(x)[0] + r * beta(x, f)
        
from scipy.optimize import minimize
res = minimize(lambda x : function_with_barrier(x, f_constrained, 1),
               [0.5, 0.5], method = 'Nelder-Mead', options = {'disp': True})
print(res.x)
