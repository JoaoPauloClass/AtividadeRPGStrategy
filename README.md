# AtividadeRPGStrategy

Sistema de combate para RPG medieval utilizando o padrão de projeto Strategy para gerenciar diferentes tipos de armas e seus efeitos especiais.

## 📋 Contexto

Em um RPG medieval, diferentes classes de personagens podem utilizar variados tipos de armas, cada uma com efeitos especiais únicos. O sistema foi projetado para ser flexível e permitir a adição de novas armas e personagens facilmente.

## 🎯 Objetivo

Implementar um sistema de combate usando o padrão Strategy onde personagens podem equipar e utilizar diferentes armas com efeitos especiais distintos.

## ⚔️ Armas Disponíveis

### Espada Longa
- **Dano Base:** 15
- **Efeito Especial:** "Corte Profundo" - 30% de chance de causar sangramento (dano adicional de 5 por 3 turnos)
- **Custo Mana:** 0
- **Requisito:** Força ≥ 10

### Arco Élfico
- **Dano Base:** 12
- **Efeito Especial:** "Chuva de Flechas" - Ataque em área, atinge todos os inimigos
- **Custo Mana:** 15
- **Requisito:** Destreza ≥ 8

### Cajado Arcano
- **Dano Base:** 8
- **Efeito Especial:** "Bola de Fogo" - Causa queimadura (dano de 10 por 2 turnos)
- **Custo Mana:** 25
- **Requisito:** Inteligência ≥ 12

### Machado de Guerra
- **Dano Base:** 18
- **Efeito Especial:** "Golpe Esmagador" - 25% de chance de atordoar o inimigo (perde 1 turno)
- **Custo Mana:** 5
- **Requisito:** Força ≥ 15

### Adaga Sombria
- **Dano Base:** 10
- **Efeito Especial:** "Ataque Furtivo" - Dano triplo se o inimigo estiver desprevenido
- **Custo Mana:** 10
- **Requisito:** Destreza ≥ 12

## 🛡️ Classes de Personagens

### Guerreiro
- **Atributos Base:** Força 15, Destreza 8, Inteligência 5
- **Vida:** 120
- **Mana:** 50
- **Habilidade Passiva:** "Pele Dura" - Reduz dano recebido em 20%
- **Armas Permitidas:** Espadas, Machados

### Arqueiro
- **Atributos Base:** Força 8, Destreza 15, Inteligência 7
- **Vida:** 90
- **Mana:** 80
- **Habilidade Passiva:** "Esquiva" - 25% de chance de evitar um ataque
- **Armas Permitidas:** Arcos, Adagas

### Mago
- **Atributos Base:** Força 5, Destreza 7, Inteligência 18
- **Vida:** 70
- **Mana:** 150
- **Habilidade Passiva:** "Regeneração de Mana" - +10 mana por turno
- **Armas Permitidas:** Cajados, Adagas

## 🔧 Implementações Recomendadas

### 1. Implementação Base
- [ ] Implementar a interface `Arma` e pelo menos 3 tipos de armas diferentes
- [ ] Criar as classes `Guerreiro`, `Arqueiro` e `Mago`
- [ ] Implementar o método `atacar()` com dano básico

### 2. Efeitos Especiais
- [ ] Implementar o sistema de `StatusEffect`
- [ ] Adicionar pelo menos 3 efeitos diferentes (sangramento, queimadura, atordoado)
- [ ] Implementar a lógica de aplicação de efeitos nas armas

### 3. Sistema de Batalha
- [ ] Criar a classe `Batalha` que gerencia turnos
- [ ] Implementar troca de armas durante a batalha
- [ ] Adicionar lógica de vitória/derrota

### 4. Extensões (Opcional)
- [ ] Adicionar uma nova arma com efeito único
- [ ] Implementar um sistema de crítico (dano aleatório)
- [ ] Criar um personagem híbrido (ex: Paladino)

## 🎓 Padrão de Projeto

Este projeto utiliza o **padrão Strategy** para permitir que personagens possam trocar de armas dinamicamente durante o combate, sem alterar a estrutura das classes de personagens.

## 📚 Conceitos Aplicados

- Padrão Strategy
- Polimorfismo
- Encapsulamento
- Interfaces
- Composição sobre Herança
- Sistema de Efeitos de Status

---

**Nota:** Este é um projeto educacional para prática de padrões de projeto e programação orientada a objetos.