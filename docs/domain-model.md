# Modelo de Domínio - Treinos TKS

## Objetivo

O sistema Treinos TKS tem como objetivo registrar treinos realizados pelos participantes de uma comunidade, aplicando automaticamente regras de pontuação, streaks, conquistas, rankings e penalidades.

O sistema deve manter histórico completo dos eventos para permitir auditoria e rastreabilidade.

---

# Conceitos Fundamentais

## Participante

Pessoa pertencente à comunidade.

### Responsabilidades

* Registrar treinos.
* Consultar pontuação.
* Consultar ranking.
* Receber conquistas.
* Receber penalidades.

---

## Treino

Registro submetido por um participante.

### Atributos

* Data do treino
* Foto comprobatória
* Observação opcional
* Status

### Status possíveis

* PENDENTE
* APROVADO
* REJEITADO

---

## Evento

Representa qualquer ocorrência relevante dentro do sistema.

Todo histórico da aplicação deve ser registrado através de eventos.

Exemplos:

* TREINO_REGISTRADO
* TREINO_APROVADO
* PONTO_CONCEDIDO
* PONTO_REMOVIDO
* STREAK_ATUALIZADA
* CONQUISTA_RECEBIDA
* PARTICIPANTE_EXPULSO

Nenhuma alteração importante deve ocorrer sem gerar um evento.

---

## Pontuação

A pontuação não deve ser considerada a fonte principal da verdade.

A fonte principal da verdade são os eventos.

A pontuação atual pode ser calculada através dos eventos registrados.

---

## Rank

Representa o nível do participante.

O rank é determinado automaticamente com base na pontuação atual.

---

## Conquista

Representa um marco alcançado pelo participante.

Exemplos:

* Primeiro treino
* 10 treinos
* 30 treinos
* 7 dias consecutivos
* 30 dias consecutivos

---

## Penalidade

Evento negativo aplicado automaticamente ou manualmente.

Exemplos:

* 3 dias válidos sem treinar
* Descumprimento de regras da comunidade

---

## Comunidade

Grupo de participantes.

O sistema deve permitir múltiplas comunidades futuramente.
