def test():
    acronym = ""
    for w in "Hello Seunghwan Lee".split():
        acronym = acronym + w[0].upper()

    print(acronym)
test()
