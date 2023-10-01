# Repo TuBes Algeo K01 IF 2022/2023

<p align="center">
  <img height="360px" src="https://media.discordapp.net/attachments/1138429958486769706/1152174025112555610/IMG_20230915_162608.jpg?ex=65193bad&is=6517ea2d&hm=dd1b409d823bc8e47baf1c368dee9a4678076373d2abc48c61aaf702895af6da&=&width=935&height=701" alt="logo HMIF"/>
  <br>
  <a><i><sup>Personil kelompok "Daspro Gagal A"</sup></i></a>
</p>

## Anggota 
1. Maria Flora Renata Siringoringo (13522010)
2. M Athaullah Daffa Kusuma M (13522044)
3. Dzaky Satrio Nugroho (13522059)

## Jangan lupa Setup Dulu
1. Clone repo

```
git clone https://github.com/yoshikazuuu/draft-website-genshiken.git
```

2. Pull, Jangan lupa pull dulu sebelum ngerjain

```
git pull
```

## Kontribusi
1. Buat branch baru

```
git checkout -b <branch-name>
```

2. Editkeun

3. Commit and push

```
git add .
git commit -m "<commit-message>"
git push origin <branch-name>
```

4. Create a pull request

5. Wait for approval

## Branching and Commit Messages

Setiap membuat branch baru harus ambil base dari `main`. Untuk penamaan commit dan branch mengikuti format berikut.
Format branch: `<type>/<title>`, contoh `feat/Navbar`.
Format commit: `<type>: <subject>`, contoh `feat: add navbar`.
Penamaan menggunakan camel case

Untuk type mengikuti semantic berikut.

- `feat`: (new feature for the user, not a new feature for build script)
- `fix`: (bug fix for the user, not a fix to a build script)
- `docs`: (changes to the documentation)
- `style`: (formatting, missing semi colons, etc; no production code change)
- `refactor`: (refactoring production code, eg. renaming a variable)
- `test`: (adding missing tests, refactoring tests; no production code change)
- `chore`: (updating grunt tasks etc; no production code change)
