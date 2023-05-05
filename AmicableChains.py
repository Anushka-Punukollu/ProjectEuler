def proper_divisors(n):
    divisors = [1]
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            divisors.append(i)
            if i != n // i:
                divisors.append(n // i)
    return divisors

def amicable_chain(n):
    chain = [n]
    while True:
        next_num = sum(proper_divisors(chain[-1]))
        if next_num == n:
            return chain
        if next_num in chain:
            return chain[chain.index(next_num):]
        chain.append(next_num)

max_length = 0
for n in range(1, 1000000):
    chain = amicable_chain(n)
    if len(chain) > max_length:
        max_length = len(chain)
        smallest_member = min(chain)
print(smallest_member)
