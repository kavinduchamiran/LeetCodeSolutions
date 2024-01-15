x = "maximum-depth-of-binary-tree"

x = x.split("-")
final = ""
for i in x:
    final += i[0].upper() + i[1:]
final += ".Solution"
print(final)