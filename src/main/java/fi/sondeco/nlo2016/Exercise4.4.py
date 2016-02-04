import numpy as np
import ad

def f_constrained(x):
    return x[0] ** 2 + x[1] ** 2 + x[0] + 2 * x[1], [],[x[0] + x[1] - 1]
    
def gradf(f):
	return ad.gh(f)[0]
	
opt = [0.75, 0.25]
print("Gradient of f at optimal: ", gradf(lambda x : f_constrained(x)[0])(opt))    

print("Gradient of constraint at optimal: ", gradf(lambda x : x[0] + x[1] - 1)(opt))

#print("Inequality constraint values at optimal: ", f_constrained(opt)[1])
#print("Equality constraint values at optimal: ", f_constrained(opt)[2])
#??print("Gradient of constraint at optimal: ", gradf(lambda x : f_constrained(x)[2])(opt))
