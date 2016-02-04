import numpy as np
import ad
def project_vector(A, vector):
    #convert A into a matrix
    A_matrix = np.matrix(A)
    #construct the "first row" of the matrix [[I,A^T],[A,0]]
    left_matrix_first_row = np.concatenate((np.identity(len(vector)), A_matrix.transpose()), axis = 1)
    #construct the "second row" of the matrix
    left_matrix_second_row = np.concatenate((A_matrix, np.matrix(np.zeros([len(A), len(vector) + len(A) - len(A[0])]))), axis=1)
    #combine the whole matrix by combining the rows
    left_matrix = np.concatenate((left_matrix_first_row, left_matrix_second_row), axis = 0)
    #Solve the system of linear equalities from the previous page
    right_matrix = np.concatenate((np.matrix(vector).transpose(), np.zeros([len(A), 1])), axis = 0)
    return np.linalg.solve(left_matrix, right_matrix)[:len(vector)]

def projected_gradient_method(f, A, start, step, precision):
    f_old = float('Inf')
    x = np.array(start)
    steps = []
    f_new = f(x)
    while abs(f_old - f_new) > precision:
        f_old = f_new
        gradient = ad.gh(f)[0](x)
        grad_proj = project_vector(A, [-i for i in gradient])  	#The only changes to steepest..
        grad_proj = np.array(grad_proj.transpose())[0] 			#... descent are here!
        x = x + grad_proj * step
        f_new = f(x)
        steps.append(list(x))
    return x, f_new, steps
    
f = lambda x : x[0] ** 2 + x[1] ** 2 + x[0] + 2 * x[1]
A = [[1,1]]
start = [0.5, 0.5] # Note that start needs to be feasible solution
(x,f_val,steps) = projected_gradient_method(f,A,start,0.6,0.000001)

print(x)
print(f(x))
print(f([1,2]))
print(np.matrix(A)*np.matrix(x).transpose())