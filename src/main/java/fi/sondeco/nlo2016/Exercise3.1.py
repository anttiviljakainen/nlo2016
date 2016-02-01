def newtonDFP(f,start,step,precision):
    f_old = float('Inf')
    x = np.array(start)
    steps = []
    f_new = f(x)
    
    H = np.eye(len(x))
    
    while abs(f_old - f_new) > precision:
        #maybe here?
        #H = H + ((x_delta * x_delta.transpose()) / (y.transpose() * x_delta)) - ((H * y * y.transpose() * H.transpose()) / (y.transpose() * H * y))
        
        f_old = f_new
        
        grad = np.matrix(ad.gh(f)[0](x)).transpose()
        x_delta = -step * H * grad
        
        x = np.array(x + x_delta.transpose())[0]
        grad_next = np.matrix(ad.gh(f)[0](x)).transpose()
        
        y = grad_next - grad
        
        div1 = y.transpose() * x_delta
        
        H = H + ((x_delta * x_delta.transpose()) / (y.transpose() * x_delta)) - ((H * y * y.transpose() * H.transpose()) / (y.transpose() * H * y))
        
        f_new = f(x)
        steps.append(list(x))
    return x,f_new,steps
    
start = [-1, 3]
f_ex3 = lambda x: x[0] ** 2 + x[1] ** 2 + x[0] + 2 * x[1]
(x_value,f_value,steps) = newtonDFP(f_ex3,start,0.1,0.00001)
print("Optimal solution is ",x_value)