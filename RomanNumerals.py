def roman_to_int(s):
    values = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    result = 0
    prev_value = None
    for c in s:
        value = values[c]
        if prev_value is not None and prev_value < value:
            result -= 2 * prev_value
        result += value
        prev_value = value
    return result
  
def int_to_roman(n):
    symbols = [
        ('M', 1000),
        ('CM', 900),
        ('D', 500),
        ('CD', 400),
        ('C', 100),
        ('XC', 90),
        ('L', 50),
        ('XL', 40),
        ('X', 10),
        ('IX', 9),
        ('V', 5),
        ('IV', 4),
        ('I', 1)
    ]
    result = ''
    for symbol, value in symbols:
        while n >= value:
            result += symbol
            n -= value
    return result

 def int_to_roman(n):
    symbols = [
        ('M', 1000),
        ('CM', 900),
        ('D', 500),
        ('CD', 400),
        ('C', 100),
        ('XC', 90),
        ('L', 50),
        ('XL', 40),
        ('X', 10),
        ('IX', 9),
        ('V', 5),
        ('IV', 4),
        ('I', 1)
    ]
    result = ''
    
for symbol, value in symbols:
        while n >= value:
            result += symbol
            n -= value
    return result
